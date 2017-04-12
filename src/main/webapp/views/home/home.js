'use strict';

angular.module('menuman.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'views/home/home.html',
    controller: 'homeCtrl'
  });
}])

.controller("homeCtrl", ["$scope","$http","$location",'loginService',function($scope, $http,$location,loginService) {
	console.log("controller tied");
    $scope.onSubmit = function() {
       console.log("controller called!!!");
       loginService.login()
       .then(
       function(d) {
       	console.log("Service call successful!");
       	console.log("response from service :"+d.userName);
        $location.path("/dashboard" );
       },
       function(errResponse){
           console.error('Error while fetching Users');
       }
   );
       };

}]);


angular.module('menuman').factory('loginService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/login';

    var factory = {
        login: login
    };

    return factory;

    function login() {
    	console.log("in login!");
       var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+"?userName=Ramesh&passWord=123")
            .then(
            function (response) {
            	console.log("response from server :"+response.data.userName);
            	deferred.resolve(response.data);
            	
            },
            function(errResponse){
                console.error('Error while fetching Tenants');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
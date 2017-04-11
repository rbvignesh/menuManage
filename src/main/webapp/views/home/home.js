'use strict';

angular.module('menuman.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'views/home/home.html',
    controller: 'homeCtrl'
  });
}])

.controller("homeCtrl", ["$scope","$http",'loginService',function($scope, $http,loginService) {
	console.log("controller tied");
    $scope.onSubmit = function() {
       console.log("controller called!!!");
       loginService.login();
       };

}]);


angular.module('menuman').factory('loginService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/fetchAllTenants';

    var factory = {
        login: login
    };

    return factory;

    function login() {
    	console.log("in login!");
        /*var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Tenants');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;*/
    }

}]);
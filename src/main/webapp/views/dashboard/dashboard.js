'use strict';

angular.module('menuman.dashboard', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/dashboard', {
    templateUrl: 'views/dashboard/dashboard.html',
    controller: 'dashboardCtrl'
  });
}])

.controller("dashboardCtrl", ["$scope","$http",function($scope, $http) {
	console.log("dashboardCtrl controller tied");
    $scope.onSubmit = function() {
       console.log("dash boad controller called!!!");
       };

}]);



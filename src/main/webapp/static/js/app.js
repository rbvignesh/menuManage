'use strict';

// Declare app level module which depends on views, and components
angular.module('menuman', [
  'ngRoute',
  'menuman.home','menuman.dashboard','menuman.manageTenants'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
	console.log("in 1");
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/home'});
}]);
'use strict';

angular.module('menuman.manageTenants', ['ngRoute','angularModalService','xeditable'])
.run(function(editableOptions) {
	editableOptions.theme = 'bs3'; // bootstrap3 theme. Can be also 'bs2', 'default'
})

.constant('TenantSchema', {
	type: 'object',
	properties: {
		name: { type: 'string', title: 'Name' },
		displayName: { type: 'string', title: 'Display Name' },
		email: { type: 'string', title: 'Email' },
		telNumber: { type: 'string', title: 'Telephone Number' }
	}
})
.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/manageTenants', {
		templateUrl: 'views/manageTenants/manageTenants.html',
		controller: 'manageTenantsCtrl',
		controllerAs: 'ctrl'
	});
}])

.controller("manageTenantsCtrl", ["$scope", 'ModalService','TenantService',function($scope, ModalService, TenantService) {
	var self = this;
	self.tenats=[];

	fetchAllTenants();

	function fetchAllTenants(){
		console.log("In  fetchAllTenants controller!");
		TenantService.fetchAllTenants()
		.then(
				function(d) {
					console.log("Service call successful!");
					self.tenants = d;
					console.log(">>"+self.tenants);
				},
				function(errResponse){
					console.error('Error while fetching Tenants');
				}
		);
	}

	$scope.showYesNo = function() {

		ModalService.showModal({
			templateUrl: "views/yesno.html",
			controller: "YesNoController"
		}).then(function(modal) {
			modal.element.modal();
			modal.close.then(function(result) {
				$scope.yesNoResult = result ? "You said Yes" : "You said No";
			});
		});

	};

}])

.controller('YesNoController', ['$scope', 'close', function($scope, close) {

	$scope.close = function(result) {
		close(result, 500); // close, but give 500ms for bootstrap to animate
	};

}])

.factory('TenantService', ['$http', '$q', function($http, $q){

	var REST_SERVICE_URI = 'http://localhost:8080/fetchAllTenants';

	var factory = {
			fetchAllTenants: fetchAllTenants
	};

	return factory;

	function fetchAllTenants() {
		console.log("in fetchAllTenants Service!");
		var deferred = $q.defer();
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
		return deferred.promise;
	}
}]);



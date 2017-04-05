'use strict';

angular.module('menuManApp').controller('TenantController', ['$scope', 'TenantService', function($scope, TenantService) {
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
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

}]);

'use strict';

angular.module('menuMan').controller('TenantController', ['$scope', 'TenantService', function($scope, TenantService) {
    var self = this;
    self.tenats=[];

    fetchAllTenants();

    function fetchAllTenants(){
    	TenantService.fetchAllTenants()
            .then(
            function(d) {
                self.tenants = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

}]);

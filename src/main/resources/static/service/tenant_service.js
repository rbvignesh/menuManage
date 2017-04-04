'use strict';

angular.module('menuMan').factory('TenantService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/';

    var factory = {
        fetchAllTenants: fetchAllTenants
    };

    return factory;

    function fetchAllTenants() {
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

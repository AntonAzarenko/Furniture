function order($scope, $http) {
    $http.get('http://localhost:8080/order/all')
    success(function f(data) {
        $scope.order = data;
    });
}
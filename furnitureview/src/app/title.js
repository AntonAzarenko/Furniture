function order($scope, $http) {
    $http.get('order/all')
    success(function f(data) {
        $scope.order = data;
    });
}
var myApp = angular.module("shopping-cart-app", [
  "angularUtils.directives.dirPagination",
]);
var host = "http://localhost:8080/rest";
myApp.config(function (paginationTemplateProvider) {
  paginationTemplateProvider.setPath("/customTemplate.html");
});

myApp.controller("shopping-cart-ctrl", function ($scope, $http) {
  

  $scope.cart = {
    items: [],
    moneyBill: 0,

    //Thêm sản phẩm vào giỏ hàng
    add(id) {
      var item = this.items.find((item) => item.product_id == id);
      if (item) {
        item.qty++;
        this.saveToLocalStorage();
      } else {
        $http
          .get(`/rest/product/${id}`)
          .then((resp) => {
            resp.data.qty = 1;
            this.items.push(resp.data);
            this.saveToLocalStorage();
          })
          .catch((error) => {
            console.log("Error", error);
          });
      }
    },

    //Xoá sản phẩm khỏi giỏ hàng
    remove(id) {
      var index = this.items.findIndex((item) => item.product_id == id);
      this.items.splice(index, 1);
      this.saveToLocalStorage();
    },

    //Xoá sạch các mặt hàng trong giỏ
    clear() {
      this.items = [];
      this.saveToLocalStorage();
    },

    //Tính thành tiền của một sản phẩm
    amt_of(item) {},

    //Tính tổng số lượng các mặt hàng trong giỏ
    get count() {
      return this.items
        .map((item) => item.qty)
        .reduce((total, qty) => (total += qty), 0);
    },

    //Tổng thành tiền các mặt hàng trong giỏ
    get amount() {
      return this.items
        .map((item) => item.qty * item.product_price)
        .reduce((total, qty) => (total += qty), 0);
    },
    //Lưu giỏ hàng vào local storage
    saveToLocalStorage() {
      //dùng angular để copy xong đổi các mặt hàng sang json
      var json = JSON.stringify(angular.copy(this.items));
      localStorage.setItem("cart", json);
    },

    //Đọc giỏ hàng từ local storage
    loadFromLocalStorage() {
      var json = localStorage.getItem("cart");
      this.items = json ? JSON.parse(json) : [];
    },
  };
  //$scope.cart.clear();
  $scope.cart.loadFromLocalStorage();
});

myApp.controller("MyController", function ($scope, $http) {
  $scope.currentPage = 1;
  $scope.pageSize = 12;

  $scope.items = [];
	$scope.meals = [];

  $scope.loadBrand = function (idBrand) {
    var url = `${host}/product?cid=${idBrand}`;
    $http
      .get(url)
      .then((resp) => {
        //$scope.items = resp.data;
        $scope.meals = [];
        $scope.meals = resp.data;
        console.log("Success Brand ", resp);
      })
      .catch((error) => {
        console.log("Error", error);
      });
  };
  var dishes = [
    "noodles",
    "sausage",
    "beans on toast",
    "cheeseburger",
    "battered mars bar",
    "crisp butty",
    "yorkshire pudding",
    "wiener schnitzel",
    "sauerkraut mit ei",
    "salad",
    "onion soup",
    "bak choi",
    "avacado maki",
  ];
  var sides = [
    "with chips",
    "a la king",
    "drizzled with cheese sauce",
    "with a side salad",
    "on toast",
    "with ketchup",
    "on a bed of cabbage",
    "wrapped in streaky bacon",
    "on a stick with cheese",
    "in pitta bread",
  ];
  //   for (var i = 1; i <= 100; i++) {
  //     var dish = dishes[Math.floor(Math.random() * dishes.length)];
  //     var side = sides[Math.floor(Math.random() * sides.length)];
  //     $scope.meals.push('meal ' + i + ': ' + dish + ' ' + side);
  //   }

  $scope.load_all = function () {
	var xhref = location.href;
	var xid = xhref[xhref.length - 1];
	xid = xid*1;
	var url;
	if(Number.isInteger(xid)) {
		url = `${host}/product?cid=${xid}`;
	}else {
		url = `${host}/product`;
	}
    $http
      .get(url)
      .then((resp) => {
        //$scope.items = resp.data;
        $scope.meals = resp.data;
        console.log("Success", resp);
      })
      .catch((error) => {
        console.log("Error", error);
      });
  };
	
  $scope.load_all();
  $scope.pageChangeHandler = function (num) {
    console.log("meals page changed to " + num);
  };
});

myApp.controller("OtherController", function ($scope) {
  $scope.pageChangeHandler = function (num) {
    console.log("going to page " + num);
  };
});

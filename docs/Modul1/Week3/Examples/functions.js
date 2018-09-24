function myFunction(p1, p2) {
	return p1 * p2;
}
console.log(myFunction(100, 300));

function someFunction(p1, p2) {
	return arguments[0] * arguments[1];
}
console.log(someFunction(100, 300));

var sub = function (n1, n2) {
	return n1 - n2;
}
console.log(sub(8, 2));

function doIt(anonymous) {
	anonymous();
}
doIt(function () { console.log("Anonymous function...") });

(function () {
	console.log("SelfInvoked Syntax1!!!");
})();

!function () {
	console.log("SelfInvoked Syntax2!!!");
}();

var f1 = function () { };
var f2 = strangeFunction(f1);
function strangeFunction(p1) {
	return function () { console.log("Returning function...") };
}
f2();

function simpleFunction(p1, p2, callback) {
	console.log('The parameters: ' + p1 + ', ' + p2);

	callback();
}
simpleFunction(3, 5, function () { console.log("Do this...") });
simpleFunction(3, 5, function () { console.log("Do something else...") });

function aAsync() {
	setTimeout(function () { console.log("Delayed..."); }, 2000);
}
aAsync();
console.log("What come first, this or delayed...");

var numbers = [1, -4, 9];
var newSign = numbers.map(function (num) {
	return num * -1;
});
console.log(numbers);
console.log(newSign);

var names = ["kurt", "ole", "hans", "ib"];
names.forEach(function (name) {
	console.log(name);
});
var newArray = names.filter(function (name) {
	return name.length <= 3;
});
console.log(newArray);
var mapArray = names.map(function (name) {
	return name.toUpperCase();
});
console.log(mapArray);

function containerFunction() {
	function NestedFunction() {
		console.log("NestedFunction...");
	};
	NestedFunction();
}
containerFunction();

var makeCounter = function () {
	var privateCounter = 0;
	function changeBy(val) {
		privateCounter += val;
	}
	return {
		increment: function () { changeBy(1); },
		decrement: function () { changeBy(-1); },
		value: function () { return privateCounter; }
	}
};
var counter1 = makeCounter();
var counter2 = makeCounter();
counter1.increment();
counter1.increment();
console.log(counter1.value());
console.log(counter2.value());

var x = 10;
function y() {
	console.log(x);
	var x = 20;
	console.log(x);
}
y();

hoistedFunction();
function hoistedFunction(a, b) {
	console.log("HoistedFunction...");
}
hoistedFunction();

function hoistingDemo1() {
	var myCoolObject;
	console.log(myCoolObject);

	if (!myCoolObject) {
		myCoolObject = { value: "cool" };
		console.log(myCoolObject.value);
	}
}
hoistingDemo1();

function hoistingDemo2() {
	function f1() {
		console.log("I'm f1");
	}
	var f2;
	f2 = function () {
		console.log("I'm f2");
	}
	f1();
	f2();
}
hoistingDemo2();
var car1 = {color: "red", wheels: 4};

function Car(color, wheels) {
	this.color = color;
	this.wheels = wheels;
}
var car2 = new Car("red", 4);

console.log(car1.color);
console.log(car2["color"]);

function FamilyMember(first, last, age) {
    this.firstName = first;
    this.lastName = last;
    this.age = age;
    this.name = function(){return this.firstName + " " + this.lastName;};
}
var myFather = new FamilyMember("John", "Doe", 50);
var myMother = new FamilyMember("Jane", "Doe", 48);
console.log(myFather.firstName);
console.log(myMother["lastName"]);
console.log(myMother.age);
console.log(myFather.name());

FamilyMember.prototype.nationality = "English"; 
FamilyMember.prototype.nameUpper = function(){return (this.firstName + " " + this.lastName).toUpperCase()}; 
console.log(myMother.nationality);
console.log(myFather.nameUpper());
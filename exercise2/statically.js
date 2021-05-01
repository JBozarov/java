class Statically {
    //fix this code, so all of the instantiation and console.logs() work.  Try not to change the signature of the class, unless absolutely necessary.
    static #glue = "Epoxy";
    jello = "Jello";

    moveAndShake() {
        console.log("Never stagnate in life.  Be agile, change, and improve...");
    }

    static stubborn() {
        // this.moveAndShake(); // this is non static method, We cannot invoke it inside a Class itself
        console.log("Please don't make me change... I just don't like it...");
    }

    static explain() {
        this.stubborn();
        console.log(Statically.#glue); // glue is a static so It can be called only from the Class itself
		console.log("I wrote explanation in each line where functions or variable invoked write an explanation for how the keyword static behaves differently in javascript vs. java. Another way of accessing #glue is using getter method, but I still have to call Class to access it")
    }

		getGlue (){
			return Statically.#glue;
		}


}

//get the below code to run correctly without errors:  Make sure you explain what you did in the the explain() method, defined in the class.  Do NOT remove the 'static' keyword from the explain() method.

const stats = new Statically();

stats.moveAndShake();
Statically.stubborn(); // static method can be called by Class only not by Class instances
Statically.explain(); // static method can be called by Class only not by Class instances

console.log(stats.getGlue()); // #glue cannot be invoked from instance either we need to use
stats.getGlue() // In order to make getGlue to work, I returned Statically.#glue inside a getGlue because glue is a static and private variable
// console.log(stats.jello);

// Once you have finished getting statistically.js to run, refactor the code here in Java.

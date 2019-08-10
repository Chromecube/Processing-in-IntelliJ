# Processing in plain Java using Maven

[Processing](https://processing.org) is a great tool for creative programming, but I felt a bit limited by the Processing Editor 
and wanted to use it in good old [IntelliJ](https://www.jetbrains.com/idea).

## Setting up your pom.xml

As the name of the repository might suggest, you will need a Maven dependecy create a Processing sketch in your IDE. There you go:

```xml
<dependency>
	<groupId>org.processing</groupId>
	<artifactId>core</artifactId>
	<version>3.3.7</version>
</dependency>
```

The version number might be outdated, you should probably use the latest version [![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.processing/core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.processing/core).
As soon as you have imported the dependecy you are good to go! You can always have a look at the `pom.xml` file to see how I did this.

_(Of course you can also use Gradle, Leiningen or whatever build tool you normally use)_

## Creating your Java class

1. Create a class inside a package! In this example it's `me.niklas.processingtest.BouncingBall`.
2. This class will function as your Main class. Make sure it's extending `PApplet`.
3. Create your main() method.
4. Inside your main method, write down `PApplet.main("<my.package.class>");`. Make sure to replace the placeholder, i.e. with `me.niklas.processingtest.BouncingBall`.
5. Create a `public void settings()` method, it will act in the same way as your `setup()` method in Processing.
6. Create a method called `public void draw()`, you already now it from Processing.

```java
package package.Test;

import processing.core.PApplet;
import java.util.Random;

public Test extends PApplet {

	private final Random r = new Random();

	public static void main(String[] args) {
		PApplet.main("package.Test");
	}
	
	public void settings() {
		size(400, 400);
		//IMPPORTANT: The objects surface and frame are null in the settings method!
	}
	
	public void draw() {
		int c = r.nextInt(256);
		background(c);
		surface.setTitle(String.format("Processing Test [Color: %d]" ,c));
		frameRate(20);
	}

}
```

And there you go! Everything should work just fine. Check out my class to see [one slightly altered example from the Processing example page](https://processing.org/examples/bouncingball.html) implemented.
Now have fun building!

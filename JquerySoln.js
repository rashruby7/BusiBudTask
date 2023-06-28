// Front-end Challenge We provided some simple JavaScript template code. Your goal is to modify the application so that you can properly toggle the button to switch between an ON state and an OFF state. When the button is on and it is clicked, it turns off and the text within it changes from on to OFF and vice versa. You are free to add classes and styles, but make sure you leave the element ID's as they are. Submit your code once it is complete and our system will validate your output.
// Provided code is 
// Import $ from "jquery;
// const rootApp =document.getElementById("root"); rootApp.innerHTML =<button>ON</button>,';



import $ from "jquery";

const rootApp = document.getElementById("root");
rootApp.innerHTML = '<button id="toggleButton">ON</button>';

$("#toggleButton").on("click", function() {
  const buttonText = $(this).text();

  if (buttonText === "ON") {
    $(this).text("OFF");
    $(this).removeClass("on").addClass("off");
  } else {
    $(this).text("ON");
    $(this).removeClass("off").addClass("on");
  }
});

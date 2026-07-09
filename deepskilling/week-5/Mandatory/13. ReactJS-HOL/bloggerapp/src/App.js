import React, { useState } from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {
  const [selected, setSelected] = useState("book");
  const [showExtra, setShowExtra] = useState(true);

  // --- Technique 1: if / else inside a function ---
  function renderBySwitch() {
    switch (selected) {
      case "book":
        return <BookDetails />;
      case "blog":
        return <BlogDetails />;
      case "course":
        return <CourseDetails />;
      default:
        return null;
    }
  }

  // --- Technique 2: Element variable ---
  let statusMessage;
  if (selected === "book") {
    statusMessage = <p>You are viewing Book details.</p>;
  } else if (selected === "blog") {
    statusMessage = <p>You are viewing Blog details.</p>;
  } else {
    statusMessage = <p>You are viewing Course details.</p>;
  }

  return (
    <div style={{ textAlign: "center", marginTop: "30px" }}>
      <h1>Blogger App</h1>

      <button onClick={() => setSelected("book")}>Show Book</button>
      <button onClick={() => setSelected("blog")} style={{ marginLeft: "10px" }}>
        Show Blog
      </button>
      <button onClick={() => setSelected("course")} style={{ marginLeft: "10px" }}>
        Show Course
      </button>

      {/* Technique 2 output: element variable */}
      {statusMessage}

      {/* Technique 1 output: switch-case function */}
      {renderBySwitch()}

      <hr />

      {/* Technique 3: Ternary operator */}
      {selected === "book" ? <p>(Ternary check: this is the Book)</p> : <p>(Ternary check: not the Book)</p>}

      {/* Technique 4: Logical && operator */}
      <button onClick={() => setShowExtra(!showExtra)}>
        Toggle Extra Info
      </button>
      {showExtra && <p>Extra info: React makes conditional rendering easy!</p>}
    </div>
  );
}

export default App;
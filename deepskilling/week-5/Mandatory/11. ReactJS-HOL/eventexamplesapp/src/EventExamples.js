import React from "react";

class EventExamples extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
      helloMessage: "",
      welcomeMessage: "",
      pressMessage: "",
    };
  }

  increment = () => {
    this.setState({ count: this.state.count + 1 });
  };

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  sayHello = () => {
    this.setState({ helloMessage: "Hello, Welcome to React Events!" });
  };

  // Increment button invokes TWO methods
  handleIncrementClick = () => {
    this.increment();
    this.sayHello();
  };

  // Function that takes an argument
  sayWelcome = (name) => {
    this.setState({ welcomeMessage: `Welcome ${name}` });
  };

  // Synthetic event handler
  handlePress = (event) => {
    this.setState({ pressMessage: "I was clicked" });
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "30px" }}>
        <h1>Event Examples</h1>

        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.handleIncrementClick}>Increment</button>
        <button onClick={this.decrement} style={{ marginLeft: "10px" }}>
          Decrement
        </button>
        <p>{this.state.helloMessage}</p>

        <hr />

        <button onClick={() => this.sayWelcome("welcome")}>
          Say Welcome
        </button>
        <p>{this.state.welcomeMessage}</p>

        <hr />

        <button onClick={this.handlePress}>Press Me</button>
        <p>{this.state.pressMessage}</p>
      </div>
    );
  }
}

export default EventExamples;
import React from "react";

class CountPeople extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0,
    };
  }

  updateEntry = () => {
    this.setState({ entrycount: this.state.entrycount + 1 });
  };

  updateExit = () => {
    this.setState({ exitcount: this.state.exitcount + 1 });
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "30px" }}>
        <h1>Mall Entry/Exit Counter</h1>

        <button onClick={this.updateEntry}>Login</button>
        <button onClick={this.updateExit} style={{ marginLeft: "10px" }}>
          Exit
        </button>

        <h2>Number of people entered: {this.state.entrycount}</h2>
        <h2>Number of people exited: {this.state.exitcount}</h2>
      </div>
    );
  }
}

export default CountPeople;
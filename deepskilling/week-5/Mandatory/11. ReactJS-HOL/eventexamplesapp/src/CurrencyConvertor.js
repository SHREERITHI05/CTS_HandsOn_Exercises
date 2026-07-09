import React from "react";

class CurrencyConvertor extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: "",
      euros: null,
    };
  }

  handleChange = (event) => {
    this.setState({ rupees: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const rate = 90; // approx: 1 EUR = 90 INR
    const euroValue = (this.state.rupees / rate).toFixed(2);
    this.setState({ euros: euroValue });
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "30px" }}>
        <h1>Currency Convertor</h1>
        <label>Rupees: </label>
        <input
          type="number"
          value={this.state.rupees}
          onChange={this.handleChange}
        />
        <button onClick={this.handleSubmit} style={{ marginLeft: "10px" }}>
          Convert
        </button>
        {this.state.euros !== null && <p>Euros: € {this.state.euros}</p>}
      </div>
    );
  }
}

export default CurrencyConvertor;
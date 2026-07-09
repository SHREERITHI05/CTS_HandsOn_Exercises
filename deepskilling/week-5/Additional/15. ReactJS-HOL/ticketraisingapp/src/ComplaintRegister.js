import React from "react";

class ComplaintRegister extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      employeeName: "",
      complaint: "",
    };
  }

  handleNameChange = (event) => {
    this.setState({ employeeName: event.target.value });
  };

  handleComplaintChange = (event) => {
    this.setState({ complaint: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    // Generate a simple reference number
    const refNumber = "REF" + Math.floor(100000 + Math.random() * 900000);

    alert(
      `Complaint Registered!\nEmployee: ${this.state.employeeName}\nReference Number: ${refNumber}`
    );

    // Reset form after submit
    this.setState({ employeeName: "", complaint: "" });
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "30px" }}>
        <h1>Complaint Register</h1>
        <form onSubmit={this.handleSubmit}>
          <div style={{ marginBottom: "10px" }}>
            <label>Employee Name: </label>
            <input
              type="text"
              value={this.state.employeeName}
              onChange={this.handleNameChange}
              required
            />
          </div>

          <div style={{ marginBottom: "10px" }}>
            <label>Complaint: </label>
            <br />
            <textarea
              rows="4"
              cols="40"
              value={this.state.complaint}
              onChange={this.handleComplaintChange}
              required
            />
          </div>

          <button type="submit">Submit Complaint</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
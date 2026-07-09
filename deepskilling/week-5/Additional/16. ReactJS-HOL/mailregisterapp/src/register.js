import React from "react";

class Register extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      email: "",
      password: "",
      errors: {
        name: "",
        email: "",
        password: "",
      },
    };
  }

  handleChange = (event) => {
    const { name, value } = event.target;
    this.setState({ [name]: value });
  };

  validate = () => {
    let errors = { name: "", email: "", password: "" };
    let isValid = true;

    if (this.state.name.length < 5) {
      errors.name = "Name should have at least 5 characters";
      isValid = false;
    }

    if (!this.state.email.includes("@") || !this.state.email.includes(".")) {
      errors.email = "Email should contain @ and .";
      isValid = false;
    }

    if (this.state.password.length < 8) {
      errors.password = "Password should have at least 8 characters";
      isValid = false;
    }

    this.setState({ errors });
    return isValid;
  };

  handleSubmit = (event) => {
    event.preventDefault();

    if (this.validate()) {
      alert(`Registration successful!\nWelcome, ${this.state.name}`);
      this.setState({
        name: "",
        email: "",
        password: "",
        errors: { name: "", email: "", password: "" },
      });
    }
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "30px" }}>
        <h1>Register</h1>
        <form onSubmit={this.handleSubmit}>
          <div style={{ marginBottom: "10px" }}>
            <label>Name: </label>
            <input
              type="text"
              name="name"
              value={this.state.name}
              onChange={this.handleChange}
            />
            {this.state.errors.name && (
              <p style={{ color: "red" }}>{this.state.errors.name}</p>
            )}
          </div>

          <div style={{ marginBottom: "10px" }}>
            <label>Email: </label>
            <input
              type="text"
              name="email"
              value={this.state.email}
              onChange={this.handleChange}
            />
            {this.state.errors.email && (
              <p style={{ color: "red" }}>{this.state.errors.email}</p>
            )}
          </div>

          <div style={{ marginBottom: "10px" }}>
            <label>Password: </label>
            <input
              type="password"
              name="password"
              value={this.state.password}
              onChange={this.handleChange}
            />
            {this.state.errors.password && (
              <p style={{ color: "red" }}>{this.state.errors.password}</p>
            )}
          </div>

          <button type="submit">Register</button>
        </form>
      </div>
    );
  }
}

export default Register;
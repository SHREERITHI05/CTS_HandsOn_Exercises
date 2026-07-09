import React from "react";

class Getuser extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      title: "",
      firstname: "",
      picture: "",
      loading: true,
    };
  }

  componentDidMount() {
    fetch("https://api.randomuser.me/")
      .then((response) => response.json())
      .then((data) => {
        const user = data.results[0];
        this.setState({
          title: user.name.title,
          firstname: user.name.first,
          picture: user.picture.large,
          loading: false,
        });
      })
      .catch((error) => {
        console.error("Error fetching user:", error);
        this.setState({ loading: false });
      });
  }

  render() {
    if (this.state.loading) {
      return <p>Loading user...</p>;
    }

    return (
      <div style={{ textAlign: "center", marginTop: "30px" }}>
        <h1>Random User</h1>
        <img src={this.state.picture} alt={this.state.firstname} />
        <h2>
          {this.state.title}. {this.state.firstname}
        </h2>
      </div>
    );
  }
}

export default Getuser;
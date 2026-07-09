import React from "react";
import Cart from "./Cart";

class OnlineShopping extends React.Component {
  constructor(props) {
    super(props);
    this.cartItems = [
      new Cart("Wireless Mouse", 599),
      new Cart("Bluetooth Headphones", 1499),
      new Cart("Laptop Stand", 899),
      new Cart("Mechanical Keyboard", 2999),
      new Cart("USB-C Hub", 1199),
    ];
  }

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "30px" }}>
        <h1>Online Shopping Cart</h1>
        <table style={{ margin: "0 auto", borderCollapse: "collapse" }}>
          <thead>
            <tr>
              <th style={{ border: "1px solid black", padding: "8px" }}>Item Name</th>
              <th style={{ border: "1px solid black", padding: "8px" }}>Price</th>
            </tr>
          </thead>
          <tbody>
            {this.cartItems.map((item, index) => (
              <tr key={index}>
                <td style={{ border: "1px solid black", padding: "8px" }}>{item.itemName}</td>
                <td style={{ border: "1px solid black", padding: "8px" }}>₹{item.price}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;
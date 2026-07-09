import React from "react";

const flights = [
  { id: 1, from: "Chennai", to: "Delhi", time: "06:00 AM", price: 4500 },
  { id: 2, from: "Chennai", to: "Mumbai", time: "09:30 AM", price: 5200 },
  { id: 3, from: "Chennai", to: "Bangalore", time: "01:15 PM", price: 2100 },
];

function UserPage() {
  const handleBook = (flight) => {
    alert(`Ticket booked: ${flight.from} to ${flight.to} at ${flight.time}`);
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h1>Welcome! Book Your Flight</h1>
      <table style={{ margin: "0 auto", borderCollapse: "collapse" }}>
        <thead>
          <tr>
            <th style={{ border: "1px solid black", padding: "8px" }}>From</th>
            <th style={{ border: "1px solid black", padding: "8px" }}>To</th>
            <th style={{ border: "1px solid black", padding: "8px" }}>Time</th>
            <th style={{ border: "1px solid black", padding: "8px" }}>Price</th>
            <th style={{ border: "1px solid black", padding: "8px" }}>Action</th>
          </tr>
        </thead>
        <tbody>
          {flights.map((flight) => (
            <tr key={flight.id}>
              <td style={{ border: "1px solid black", padding: "8px" }}>{flight.from}</td>
              <td style={{ border: "1px solid black", padding: "8px" }}>{flight.to}</td>
              <td style={{ border: "1px solid black", padding: "8px" }}>{flight.time}</td>
              <td style={{ border: "1px solid black", padding: "8px" }}>₹{flight.price}</td>
              <td style={{ border: "1px solid black", padding: "8px" }}>
                <button onClick={() => handleBook(flight)}>Book Now</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default UserPage;
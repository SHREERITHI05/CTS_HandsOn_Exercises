import React from "react";

// Single office object - Name, Rent, Address
const office = {
  name: "Prestige Business Park",
  rent: 75000,
  address: "MG Road, Bangalore",
  image:
    "https://images.unsplash.com/photo-1497366216548-37526070297c?w=400",
};

// List of office objects to loop through
const officeSpaces = [
  {
    name: "Prestige Business Park",
    rent: 75000,
    address: "MG Road, Bangalore",
  },
  {
    name: "Ascendas IT Park",
    rent: 55000,
    address: "OMR, Chennai",
  },
  {
    name: "DLF Cyber City",
    rent: 90000,
    address: "Gurugram, Haryana",
  },
  {
    name: "Tidel Park",
    rent: 42000,
    address: "Taramani, Chennai",
  },
];

function App() {
  return (
    <div style={{ textAlign: "center", maxWidth: "500px", margin: "0 auto" }}>
      {/* Element to display heading */}
      <h1>Office Space Rental</h1>

      {/* Attribute to display the image */}
      <img src={office.image} alt={office.name} width="400" />

      {/* Object details */}
      <h2>Featured Office</h2>
      <p>Name: {office.name}</p>
      <p>
        Rent:{" "}
        <span style={{ color: office.rent < 60000 ? "red" : "green" }}>
          {office.rent}
        </span>
      </p>
      <p>Address: {office.address}</p>

      {/* Loop through list of office objects */}
      <h2>All Available Office Spaces</h2>
      <ul style={{ listStyle: "none", padding: 0 }}>
        {officeSpaces.map((space, index) => (
          <li key={index} style={{ marginBottom: "20px" }}>
            <p>Name: {space.name}</p>
            <p>
              Rent:{" "}
              <span
                style={{ color: space.rent < 60000 ? "red" : "green" }}
              >
                {space.rent}
              </span>
            </p>
            <p>Address: {space.address}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
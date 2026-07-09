import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  return (
    <div style={{ border: "1px solid gray", padding: "10px", margin: "10px" }}>
      <p>{employee.name} - {employee.role}</p>
      <button className={theme === "dark" ? "btn-dark" : "btn-light"}>
        View Profile
      </button>
    </div>
  );
}

export default EmployeeCard;
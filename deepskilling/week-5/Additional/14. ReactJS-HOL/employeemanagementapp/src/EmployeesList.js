import React from "react";
import EmployeeCard from "./EmployeeCard";

const employees = [
  { id: 1, name: "Aathma Krishnan", role: "React Developer" },
  { id: 2, name: "Apoorv Mehta", role: "Java Developer" },
  { id: 3, name: "Elisa Smith", role: ".NET Developer" },
];

function EmployeesList() {
  return (
    <div>
      <h2>Employees List</h2>
      {employees.map((emp) => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeesList;
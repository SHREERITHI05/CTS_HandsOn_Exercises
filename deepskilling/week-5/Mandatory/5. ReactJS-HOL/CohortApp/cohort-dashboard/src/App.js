import React from "react";
import CohortDetails from "./CohortDetails";

const cohorts = [
  {
    id: 1,
    name: "Digital Nurture 4.0",
    startDate: "01-Jan-2026",
    endDate: "30-Jun-2026",
    mentor: "Arun Kumar",
    trainees: 45,
    status: "ongoing",
  },
  {
    id: 2,
    name: "Digital Nurture 3.0",
    startDate: "01-Jun-2025",
    endDate: "31-Dec-2025",
    mentor: "Priya Sharma",
    trainees: 60,
    status: "completed",
  },
  {
    id: 3,
    name: "Cloud Native Bootcamp",
    startDate: "15-Feb-2026",
    endDate: "15-Aug-2026",
    mentor: "Ravi Menon",
    trainees: 30,
    status: "ongoing",
  },
];

function App() {
  return (
    <div>
      <h2>Cognizant Academy - Cohort Dashboard</h2>
      {cohorts.map((cohort) => (
        <CohortDetails key={cohort.id} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;

import React from "react";
import styles from "./CohortDetails.module.css";

function CohortDetails({ cohort }) {
  const titleColor = cohort.status === "ongoing" ? "green" : "blue";

  return (
    <div className={styles.box}>
      <h3 style={{ color: titleColor }}>{cohort.name}</h3>
      <dl>
        <dt>Start Date</dt>
        <dd>{cohort.startDate}</dd>

        <dt>End Date</dt>
        <dd>{cohort.endDate}</dd>

        <dt>Mentor</dt>
        <dd>{cohort.mentor}</dd>

        <dt>Trainees</dt>
        <dd>{cohort.trainees}</dd>

        <dt>Status</dt>
        <dd>{cohort.status}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
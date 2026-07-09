import React from "react";

// Squad of 11 Indian players, in batting order
const indianSquad = [
  "Rohit Sharma",
  "Shubman Gill",
  "Virat Kohli",
  "Shreyas Iyer",
  "KL Rahul",
  "Suryakumar Yadav",
  "Ravindra Jadeja",
  "Hardik Pandya",
  "Kuldeep Yadav",
  "Mohammed Shami",
  "Jasprit Bumrah",
];

// ES6 array destructuring: odd positions (1st, 3rd, 5th...) -> indices 0,2,4...
const [p1, , p3, , p5, , p7, , p9, , p11] = indianSquad;
// even positions (2nd, 4th, 6th...) -> indices 1,3,5...
const [, p2, , p4, , p6, , p8, , p10] = indianSquad;

const oddTeamPlayers = [p1, p3, p5, p7, p9, p11];
const evenTeamPlayers = [p2, p4, p6, p8, p10];

// Two squads to merge
const T20players = ["Rohit Sharma", "Virat Kohli", "Suryakumar Yadav"];
const RanjiTrophyPlayers = ["Sarfaraz Khan", "Yashasvi Jaiswal", "Ruturaj Gaikwad"];

// ES6 merge feature (spread operator)
const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

function IndianPlayers() {
  return (
    <div>
      <h1>Indian Team</h1>

      <h1>Odd Players</h1>
      <ul>
        {oddTeamPlayers.map((name, index) => (
          <li key={index}>{name}</li>
        ))}
      </ul>

      <h1>Even Players</h1>
      <ul>
        {evenTeamPlayers.map((name, index) => (
          <li key={index}>{name}</li>
        ))}
      </ul>

      <h1>List of Indian Players Merged:</h1>
      <ul>
        {mergedPlayers.map((name, index) => (
          <li key={index}>{name}</li>
        ))}
      </ul>
    </div>
  );
}

export default IndianPlayers;
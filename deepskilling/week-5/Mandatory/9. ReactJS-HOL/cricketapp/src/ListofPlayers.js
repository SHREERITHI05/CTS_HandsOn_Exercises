import React from "react";

// 11 players with names and scores
const players = [
  { name: "Rohit Sharma", score: 85 },
  { name: "Virat Kohli", score: 92 },
  { name: "KL Rahul", score: 45 },
  { name: "Shreyas Iyer", score: 60 },
  { name: "Suryakumar Yadav", score: 78 },
  { name: "Hardik Pandya", score: 55 },
  { name: "Ravindra Jadeja", score: 40 },
  { name: "Jasprit Bumrah", score: 12 },
  { name: "Mohammed Shami", score: 8 },
  { name: "Kuldeep Yadav", score: 15 },
  { name: "Ishan Kishan", score: 68 },
];

function ListofPlayers() {
  // arrow function inside filter() - ES6 arrow function feature
  const lowScorers = players.filter((player) => player.score < 70);

  return (
    <div>
      <h1>List of Players</h1>
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            Mr. {player.name} <span>{player.score}</span>
          </li>
        ))}
      </ul>

      <h1>List of Players having Scores Less than 70</h1>
      <ul>
        {lowScorers.map((player, index) => (
          <li key={index}>
            Mr. {player.name} <span>{player.score}</span>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;
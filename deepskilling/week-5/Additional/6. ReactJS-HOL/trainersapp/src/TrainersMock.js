import Trainer from "./trainer";

const trainersMock = [
  new Trainer(
    "T101",
    "Aathma Krishnan",
    "aathma.k@cognizant.com",
    "9876543210",
    "React JS",
    ["JavaScript", "React", "Redux"]
  ),
  new Trainer(
    "T102",
    "Apoorv Mehta",
    "apoorv.m@cognizant.com",
    "9876543211",
    "Java FSD",
    ["Java", "Spring Boot", "Microservices"]
  ),
  new Trainer(
    "T103",
    "Elisa Smith",
    "elisa.s@cognizant.com",
    "9876543212",
    ".NET FSD",
    ["C#", "ASP.NET", "Azure"]
  ),
  new Trainer(
    "T104",
    "John Doe",
    "john.d@cognizant.com",
    "9876543213",
    "Angular",
    ["TypeScript", "Angular", "RxJS"]
  ),
];

export default trainersMock;
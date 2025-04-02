package iplManagementSystem;
import java.util.*;

class Players {
    int playerid;
    String name;
    String teams;
    int runs;
    int wickets;

    Players(int playerid, String name, String teams, int runs, int wickets) {
        this.playerid = playerid;
        this.name = name;
        this.teams = teams;
        this.runs = runs;
        this.wickets = wickets;
    }

    public String toString() {
        return "Player ID: " + playerid + ", Player Name: " + name + ", Team: " + teams + ", Runs: " + runs + ", Wickets: " + wickets;
    }
}

class IPLManagementSystem {
    private ArrayList<Players> players = new ArrayList<>();
    private HashMap<Integer, Players> playerMap = new HashMap<>();
    
    void addPlayer(int playerid, String name, String teams, int runs, int wickets) {
        if (playerMap.containsKey(playerid)) {
            System.out.println("Player ID already exists.");
            return;
        }
        Players p = new Players(playerid, name, teams, runs, wickets);
        players.add(p);
        playerMap.put(playerid, p);
    }

    void viewAllPlayers() {
        if (players.isEmpty()) {
            System.out.println("No players available.");
            return;
        }
        for (Players p : players) {
            System.out.println(p);
        }
    }
    
    void highestRunScorer() {
        if (players.isEmpty()) {
            System.out.println("No players available.");
            return;
        }
        Players topScorer = Collections.max(players, Comparator.comparingInt(p -> p.runs));
        System.out.println("Highest Run Scorer: " + topScorer);
    }
    
    void highestWicketTaker() {
        if (players.isEmpty()) {
            System.out.println("No players available.");
            return;
        }
        Players topWicketTaker = Collections.max(players, Comparator.comparingInt(p -> p.wickets));
        System.out.println("Highest Wicket Taker: " + topWicketTaker);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IPLManagementSystem ipl = new IPLManagementSystem();

        // Adding some sample players
        ipl.addPlayer(1, "Virat Kohli", "RCB", 7000, 4);
        ipl.addPlayer(2, "MS Dhoni", "CSK", 10000, 10);
        ipl.addPlayer(3, "Rohit Sharma", "MI", 6000, 2);
        ipl.addPlayer(4, "Jasprit Bumrah", "MI", 1000, 150);
        ipl.addPlayer(5, "Pathirana", "CSK", 800, 500);

        int choice;
        do {
            System.out.println("\n1. View All Players");
            System.out.println("2. Show Highest Run Scorer");
            System.out.println("3. Show Highest Wicket Taker");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ipl.viewAllPlayers();
                    break;
                case 2:
                    ipl.highestRunScorer();
                    break;
                case 3:
                    ipl.highestWicketTaker();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}

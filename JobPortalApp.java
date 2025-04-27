import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class Job {
 private int jobId;
    private String title;
    private String description;
    private String company;

    public Job(int jobId, String title, String description, String company) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.company = company;
    }

    public int getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCompany() {
        return company;
    }
    
}

class JobSeeker {
private String name;
    private String email;

    public JobSeeker(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
}

class JobPortal {
	   private List<Job> jobs;
    private List<JobSeeker> jobSeekers;

    public JobPortal() {
        jobs = new ArrayList<>();
        jobSeekers = new ArrayList<>();
    }

    public void postJob(Job job) {
        jobs.add(job);
        System.out.println("Job posted successfully.");
    }

    public void displayAllJobs() {
        if (jobs.isEmpty()) {
            System.out.println("No jobs available.");
        } else {
            System.out.println("Available Jobs:");
            for (Job job : jobs) {
                System.out.println("Job ID: " + job.getJobId());
                System.out.println("Title: " + job.getTitle());
                System.out.println("Description: " + job.getDescription());
                System.out.println("Company: " + job.getCompany());
                System.out.println();
            }
        }
    }

    public void registerJobSeeker(JobSeeker jobSeeker) {
        jobSeekers.add(jobSeeker);
        System.out.println("Registration as Job Seeker successful.");
    }

    public void displayAllJobSeekers() {
        if (jobSeekers.isEmpty()) {
            System.out.println("No job seekers registered.");
        } else {
            System.out.println("Registered Job Seekers:");
            for (JobSeeker jobSeeker : jobSeekers) {
                System.out.println("Name: " + jobSeeker.getName());
                System.out.println("Email: " + jobSeeker.getEmail());
                System.out.println();
            }
        }
    }
   }

public class JobPortalApp {
    private static final String USERNAME = "user123"; // Predefined username
    private static final String PASSWORD = "pass123"; // Predefined password

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JobPortal jobPortal = new JobPortal();
        boolean isLoggedIn = false;
     System.out.println("Welcome to the job portal! :)");
        System.out.println();


     while(true){
            if (!isLoggedIn) {
                isLoggedIn = login(scanner);
                if (!isLoggedIn) {
                    System.out.println("Login failed. Try again.");
                    continue;
        }
     }
            System.out.println("Job Portal");
		System.out.println("");
		System.out.println("RECRUITER");
		System.out.println("");
            System.out.println("1. Post Job");
		System.out.println("");
            System.out.println("2. View Registered Job Seekers");
		System.out.println("");
		System.out.println("JOB SEEKERS");
            System.out.println("3. Register as Job Seeker");
		System.out.println("");
            System.out.println("4. View All Jobs");
System.out.println("");
            System.out.println("5. Logout");
System.out.println("");
System.out.println("6. Exit");
System.out.println("");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Job newJob = createJob(scanner);
                    jobPortal.postJob(newJob);
                    break;
                case 2:
                    jobPortal.displayAllJobSeekers();
                    break;
                case 3:
                    JobSeeker newJobSeeker = createJobSeeker(scanner);
                    jobPortal.registerJobSeeker(newJobSeeker);
                    break;
                case 4:
                    jobPortal.displayAllJobs();
                    break;
                case 5:
                    isLoggedIn = false;
                    System.out.println("Logged out successfully.");
                    break;
		case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

	 public static boolean login(Scanner scanner) {
        System.out.println("Login");
System.out.println("");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        return (username.equals(USERNAME) && password.equals(PASSWORD));
    }

 public static Job createJob(Scanner scanner) {
        System.out.println("Enter Job ID:");
        int jobId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Job Title:");
        String title = scanner.nextLine();

        System.out.println("Enter Job Description:");
        String description = scanner.nextLine();

        System.out.println("Enter Company Name:");
        String company = scanner.nextLine();

        return new Job(jobId, title, description, company);
    }

    public static JobSeeker createJobSeeker(Scanner scanner) {
        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        return new JobSeeker(name, email);
    }
}
    

   
    

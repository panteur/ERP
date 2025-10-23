# Config Service for ERP System

## Overview

This project is a **Spring Cloud Config Server** designed to provide centralized configuration for the ERP System's microservices.

It is a Spring Boot application that serves configuration files from a Git repository.

## Configuration

The configuration server is set up to serve files from the following Git repository:

-   **Git Repository URI:** `https://github.com/panteur/ERP.git`
-   **Search Path:** `data-service`
-   **Default Branch:** `master`

### Security

#### Git Repository Credentials

To connect to the Git repository, the service requires a username and a password (or a personal access token). These credentials **must** be provided via environment variables for security reasons. Do not hardcode them in the configuration files.

-   `GIT_USERNAME`: Your Git username.
-   `GIT_PASSWORD`: Your Git password or a Personal Access Token (PAT).

**Example (Linux/macOS):**
```sh
export GIT_USERNAME="your-git-username"
export GIT_PASSWORD="your-git-personal-access-token"
```

**Example (Windows PowerShell):**
```powershell
$env:GIT_USERNAME="your-git-username"
$env:GIT_PASSWORD="your-git-personal-access-token"
```

#### Service Access

Access to the configuration endpoints is secured with basic authentication. The credentials are set in `bootstrap.yml`.

-   **Username:** `user-config-service`

## How to Run

### Prerequisites

-   Java 21
-   Apache Maven

### Steps

1.  **Set Environment Variables:**
    Ensure that you have set the `GIT_USERNAME` and `GIT_PASSWORD` environment variables as described in the [Security](#security) section.

2.  **Run the application:**
    You can run the application using the Spring Boot Maven plugin:

    ```sh
    mvn spring-boot:run
    ```

3.  The service will start on port `8081`.

# Shop Project (Buy-01)

A Microservices-based E-commerce platform.

## Quick Start

### Option 1: Using Make (Recommended)

1.  **Start the Project**
    ```bash
    make start
    ```
2.  **Other Commands**
    -   Stop: `make stop`
    -   **Reset (Wipe DB & Uploads)**: `make clean`
    -   View Logs: `make logs`

### Option 2: Using Docker Compose

```bash
docker compose up -d --build
```

### Access
-   **Frontend**: [https://app.local.hello-there.net](https://app.local.hello-there.net)
-   **API**: [https://api.local.hello-there.net](https://api.local.hello-there.net)

## Testing

Import the `insomnia_export.json` file into [Insomnia](https://insomnia.rest/) to test all API endpoints.

## Storage

-   **Database**: Stored in a Docker volume.
-   **Uploaded Images**: Mapped to the `./uploads` directory on your host machine.

## Documentation

Detailed documentation has been generated for you:

-   **[Architecture & Database Guide](ARCHITECTURE.md)**: Explains the microservices, data flow, and why there are multiple MongoDB databases.

## Features
-   User Authentication (JWT)
-   Product Management (CRUD)
-   Media Uploads
-   Shopping Cart
-   Seller Dashboard

## CI/CD (Jenkins)

To start the Jenkins server:

1.  **Start Jenkins**
    ```bash
    docker compose -f docker-compose.jenkins.yml up -d --build
    ```
2.  **Access Jenkins**
    -   Open via [http://localhost:8088](http://localhost:8088)
    -   Retrieve the initial admin password:
        ```bash
        docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
        ```

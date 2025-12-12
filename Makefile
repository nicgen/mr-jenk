.PHONY: start stop clean logs

# Start all services in the background
start:
	docker compose up -d --build

# Stop all services
stop:
	docker compose down

# Stop services, remove volumes (database), and clear uploaded images
clean:
	docker compose down -v
	rm -rf uploads/*
	@echo "Database and uploads cleaned."

# View logs
logs:
	docker compose logs -f

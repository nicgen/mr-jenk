FROM jenkins/jenkins:lts-jdk17

USER root

# Install Docker CLI using static binary
RUN curl -fsSLO https://download.docker.com/linux/static/stable/x86_64/docker-26.1.3.tgz && \
    tar xzvf docker-26.1.3.tgz --strip 1 -C /usr/local/bin docker/docker && \
    rm docker-26.1.3.tgz

# Install Docker Compose Plugin
RUN mkdir -p /usr/local/lib/docker/cli-plugins && \
    curl -SL https://github.com/docker/compose/releases/download/v2.27.0/docker-compose-linux-x86_64 -o /usr/local/lib/docker/cli-plugins/docker-compose && \
    chmod +x /usr/local/lib/docker/cli-plugins/docker-compose

# Verify Docker installation
RUN docker --version && docker compose version

# Install Maven
RUN apt-get update && apt-get install -y maven

# Install Node.js (LTS)
RUN curl -fsSL https://deb.nodesource.com/setup_20.x | bash - && \
    apt-get install -y nodejs

# Install Angular CLI
RUN npm install -g @angular/cli

# Install Google Chrome for Headless testing
RUN apt-get update && apt-get install -y wget gnupg2 curl && \
    mkdir -p /usr/share/keyrings && \
    curl -fsSL https://dl-ssl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google-chrome.gpg && \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-chrome.gpg] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && \
    apt-get install -y google-chrome-stable fonts-ipafont-gothic fonts-wqy-zenhei fonts-thai-tlwg fonts-kacst fonts-freefont-ttf libxss1 \
    --no-install-recommends && \
    rm -rf /var/lib/apt/lists/*

# Set CHROME_BIN for Karma
ENV CHROME_BIN=/usr/bin/google-chrome

# Verify installations
RUN mvn -version && node -v && npm -v

# Install plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt

USER jenkins

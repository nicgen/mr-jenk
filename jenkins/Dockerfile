FROM jenkins/jenkins:lts-jdk17

USER root

# Install Docker CLI using static binary
RUN curl -fsSLO https://download.docker.com/linux/static/stable/x86_64/docker-26.1.3.tgz && \
    tar xzvf docker-26.1.3.tgz --strip 1 -C /usr/local/bin docker/docker && \
    rm docker-26.1.3.tgz

# Verify Docker installation
RUN docker --version

# Install plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt

USER jenkins

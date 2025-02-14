package com.pszymczyk.consul

import com.pszymczyk.consul.infrastructure.Ports

class ConsulPorts {

    final int httpPort
    final int httpsPort
    final int dnsPort
    final int serfLanPort
    final int serfWanPort
    final int serverPort
    final int grpcPort

    private ConsulPorts(int httpPort,int httpsPort, int dnsPort, int serfLanPort, int serfWanPort, int serverPort, int grpcPort) {
        this.httpPort = httpPort
        this.httpsPort = httpsPort
        this.dnsPort = dnsPort
        this.serfLanPort = serfLanPort
        this.serfWanPort = serfWanPort
        this.serverPort = serverPort
        this.grpcPort = grpcPort;
    }

    static ConsulPortsBuilder consulPorts() {
        return new ConsulPortsBuilder()
    }

    static class ConsulPortsBuilder {

        private int httpPort = -1
        private int httpsPort = -1
        private int dnsPort = -1
        private int serfLanPort = -1
        private int serfWanPort = -1
        private int serverPort = -1
        private int grpcPort = -1

        private ConsulPortsBuilder() {
        }

        ConsulPorts build() {
            return new ConsulPorts(
                    randomIfNotSet(httpPort),
                    randomIfNotSet(httpsPort),
                    randomIfNotSet(dnsPort),
                    randomIfNotSet(serfLanPort),
                    randomIfNotSet(serfWanPort),
                    randomIfNotSet(serverPort),
                    randomIfNotSet(grpcPort)
            )
        }

        private static int randomIfNotSet(int port) {
            return port > 0 ? port : Ports.nextAvailable()
        }

        ConsulPortsBuilder withHttpPort(int httpPort) {
            this.httpPort = httpPort
            return this
        }
        
        ConsulPortsBuilder withHttpsPort(int httpsPort) {
            this.httpsPort = httpsPort
            return this
        }

        ConsulPortsBuilder withDnsPort(int dnsPort) {
            this.dnsPort = dnsPort
            return this
        }

        ConsulPortsBuilder withSerfLanPort(int serfLanPort) {
            this.serfLanPort = serfLanPort
            return this
        }

        ConsulPortsBuilder withSerfWanPort(int serfWanPort) {
            this.serfWanPort = serfWanPort
            return this
        }

        ConsulPortsBuilder withServerPort(int serverPort) {
            this.serverPort = serverPort
            return this
        }

        ConsulPortsBuilder withGRpcPort(int grpcPort) {
            this.grpcPort = grpcPort
            return this
        }

        ConsulPortsBuilder fromConsulPorts(ConsulPorts consulPorts) {
            this.httpPort = consulPorts.httpPort
            this.httpsPort = consulPorts.httpsPort
            this.dnsPort = consulPorts.dnsPort
            this.serfLanPort = consulPorts.serfLanPort
            this.serfWanPort = consulPorts.serfWanPort
            this.serverPort = consulPorts.serverPort
            this.grpcPort = consulPorts.grpcPort
            return this
        }
    }
}

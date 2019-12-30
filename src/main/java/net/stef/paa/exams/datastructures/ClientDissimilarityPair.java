package net.stef.paa.exams.datastructures;

public class ClientDissimilarityPair {
    private final int client;
    private final int dissimilarity;

    public ClientDissimilarityPair(final int client, final int dissimilarity){
        this.client = client;
        this.dissimilarity = dissimilarity;
    }

    public int getClient() {
        return client;
    }

    public int getDissimilarity() {
        return dissimilarity;
    }

    @Override
    public String toString() {
        return client + 1 + " " + dissimilarity;
    }
}

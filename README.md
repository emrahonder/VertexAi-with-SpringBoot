
# VertexAi with SpringBoot

In this simple project, you can easily connect Vertex AI by using Langchain4j library.
For the details you can check my medium post. https://medium.com/@emrahonder/building-ai-powered-applications-with-vertex-ai-and-spring-boot-a372c57d2333

## Run Locally

Clone the project

```bash
  git clone https://link-to-project
```

Login your Gcloud acount

```bash
gcloud auth application-default login
```

Update the config on application.yml dependencies

```bash
spring:
  cloud:
    gcp:
      project-id: [YOUR-GCP-PROJECT-ID]
      location: [YOUR-GCP-PROJECT-LOCATION]
      model-name: gemini-1.5-pro # If you need you can update it as gemini-1.5-flash or newer
```

Start the server



## API Reference

#### Get your answer

```http
  GET /v1/chat
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `request` | `string` | **Required**. Your question |




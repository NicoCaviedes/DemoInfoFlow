FROM node:latest AS build

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

RUN ls -alt

FROM nginx:latest

COPY --from=build /usr/src/app/dist/front-app /usr/share/nginx/html
COPY --from=build /usr/src/app/nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/src/app/proxy.conf.json /usr/share/nginx/html/proxy.conf.json

ARG API_GATEWAY_URL
ENV API_GATEWAY_URL $API_GATEWAY_URL

EXPOSE 4200 
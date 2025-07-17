const express = require('express');
const app = express();
const cors = require('cors')
require('dotenv').config()
const PORT = process.env.PORT;

app.use(cors())
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.get('/', (req, res) => res.send('Hello from server!'));

const server =app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
const io = require('socket.io')(server, { cors: true });

io.on('connection', (socket) => {
    console.log('A client connected: ' + socket.id)

    socket.on("event_from_client", data => {
        // socket.broadcast will emit to all other clients besides the
        // client who is actually emitting
        // socket.broadcast.emit("send_data_to_all_other_clients", data);
        io.emit('Welcome', data);
    });


});




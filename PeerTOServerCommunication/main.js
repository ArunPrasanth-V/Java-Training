let peerConnection = new RTCPeerConnection()
let localStream;
let remoteStream;

let init = async () => {
    localStream = await navigator.mediaDevices.getUserMedia({video:true, audio:true})
    remoteStream = new MediaStream()
    document.getElementById('user-1').srcObject = localStream
    document.getElementById('user-2').srcObject = remoteStream

    localStream.getTracks().forEach((track) => {
        peerConnection.addTrack(track, localStream);
    });

    peerConnection.ontrack = (event) => {
        event.streams[0].getTracks().forEach((track) => {
        remoteStream.addTrack(track);
        });
    };
}

let createOffer = async () => {


    peerConnection.onicecandidate = async (event) => {
        //Event that fires off when a new offer ICE candidate is created
        if(event.candidate){
            document.getElementById('offer-sdp').value = JSON.stringify(peerConnection.localDescription)
        }
    };

    const offer = await peerConnection.createOffer();
    await peerConnection.setLocalDescription(offer);
}

peerConnection.addIceCandidate=async(event)=>{
    if(event.candidate){
        console.log("ADD ICE Candidate :",event);
     }
}
//IceCandidate incomingCandidate = new IceCandidate(candidate, sdpMid, sdpMLineIndex);


//addEventListener("a=candidate:1092112436 1 udp 2122260223 172.21.162.133 8443 typ host generation 0 network-id 1");

let createAnswer = async () => {

    let offer = JSON.parse(document.getElementById('offer-sdp').value)

    peerConnection.onicecandidate = async (event) => {
        //Event that fires off when a new answer ICE candidate is created
        if(event.candidate){
            console.log('Adding answer candidate...:', event.candidate)
           // addICECandidate(event)
            document.getElementById('answer-sdp').value = JSON.stringify(peerConnection.localDescription)
        }
    };

    await peerConnection.setRemoteDescription(offer);

    let answer = await peerConnection.createAnswer();
    await peerConnection.setLocalDescription(answer); 
}

let addAnswer = async () => {
    console.log('Add answer triggerd')
    let answer = JSON.parse(document.getElementById('answer-sdp').value)
    console.log('answer:', answer)
    if (!peerConnection.currentRemoteDescription){
        peerConnection.setRemoteDescription(answer);
    }
}
let addICECandidate=async ()=>{
   // let candidate=document.getElementById('add_ICECandidate').value;
    //candidate = new RTCIceCandidate(data.candidate);
   // console.log(candidate);
   const candidateStr1 = 'candidate:123242 1 udp 2113929471 172.22.148.17 8443 typ host generation';

   peerConnection.addIceCandidate(new RTCIceCandidate({
    candidate:`${candidateStr1}`,
    sdpMid: '0', 
    sdpMLineIndex: 0,
  }))
 .then((candidate)=>{
        console.log("Remote ICE Candidate added ");
    })
    .catch((err)=>{
        console.log("Error in Add Remote ICE candidate",err);
    })
}

init()

document.getElementById('create-offer').addEventListener('click', createOffer)
document.getElementById('create-answer').addEventListener('click', createAnswer)
document.getElementById('add-answer').addEventListener('click', addAnswer)
document.getElementById('add-candidate').addEventListener('click',addICECandidate )





  //candidate: 'candidate:2445384676 1 udp 2122194687 192.168.1.26 57088 typ host generation 0 ufrag z1J2 network-id 1 network-cost 10',

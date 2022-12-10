import axios from "axios";

export default {
    addVolunteer(volunteer) {
        return axios.post("/volunteer", volunteer);
      },

    getPendingVolunteers() {
        return axios.get('/pendingVolunteers')
      },
    
    approveVolunteerStatus(volunteerId){
        return axios.put(`/approveVolunteer/${volunteerId}`,volunteerId)
    }
    
}
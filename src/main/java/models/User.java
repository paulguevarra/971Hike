package models;


        import java.util.ArrayList;
        import java.util.List;

public class User {

        private String userName;
        private String userLocation;
        private Integer userMaxDistance;
        private int id;


        public User(String userName, String userLocation, Integer userMaxDistance) {
                this.userName = userName;
                this.userLocation = userLocation;
                this.userMaxDistance = userMaxDistance;

        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getUserLocation() {
                return userLocation;
        }

        public void setUserLocation(String userLocation) {
                this.userLocation = userLocation;
        }

        public Integer getUserMaxDistance() {
                return userMaxDistance;
        }

        public void setUserMaxDistance(Integer userMaxDistance) {
                this.userMaxDistance = userMaxDistance;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

                @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                User that = (User) o;

                if (id != that.id) return false;
                if (!userName.equals(that.userName)) return false;
                if (!userLocation.equals(that.userLocation)) return false;
                return  (!userMaxDistance.equals(that.userMaxDistance));

        }

        @Override
        public int hashCode() {
                int result = userName.hashCode();
                result = 31 * result + userLocation.hashCode();
                result = 31 * result + userMaxDistance.hashCode();
                result = 31 * result + id;
                return result;
        }
}


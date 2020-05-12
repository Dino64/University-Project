package sample.UserDB;

import sample.Model.Booking;
import sample.Model.Classroom;
import sample.Model.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClassroomDBH extends RoomDBH <Classroom> {
    @Override
    public List<? extends Room> readAvailable(Time startTime, Time endTime, Date startDate, Date endDate) throws SQLException {
        List<Classroom> classrooms;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String subQuery = "SELECT roomId FROM bookinghasroom JOIN booking ON booking.id = bookinghasroom.bookingId WHERE (startDate BETWEEN ? AND ?) OR (endDate BETWEEN ? AND ?) OR (startDate <= ?) AND (endDate >= ?)";
        String readAvailable = String.format("SELECT * FROM AllClassroom WHERE id NOT IN (%s) AND readyForBooking=1", subQuery);
        try (PreparedStatement statement = connection.prepareStatement(readAvailable)) {
            statement.setString(1, format.format(startDate));
            statement.setString(2, format.format(endDate));
            statement.setString(3, format.format(startDate));
            statement.setString(4, format.format(endDate));
            statement.setString(5, format.format(startDate));
            statement.setString(6, format.format(endDate));
            classrooms = buildModels(statement.executeQuery());
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return classrooms;
    }

    @Override
    public List<Classroom> readForBookingSpecific(Booking booking) throws SQLException {
        return null;
    }

    @Override
    public void insert(Classroom model) throws SQLException {

    }

    @Override
    public void update(Classroom model) throws SQLException {

    }

    @Override
    public void delete(Classroom model) throws SQLException {

    }

    @Override
    public List<Classroom> readAll() throws SQLException {
        return null;
    }

    @Override
    public Classroom readByPrimaryKey(String key) throws SQLException {
        Classroom classroom = null;
        String query = "SELECT * FROM AllClassRooms WHERE id=? LIMIT 1";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, Integer.parseInt(key));
            ResultSet set = statement.executeQuery();
            List<Classroom> result = buildModels(set);
            if (!result.isEmpty()) {
                classroom = result.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classroom;


}

    @Override
    public List<Classroom> buildModels(ResultSet set) throws SQLException {
        return null;
    }

}

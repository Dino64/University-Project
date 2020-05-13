package sample.UserDB;

import sample.Model.Booking;
import sample.Model.Classroom;
import sample.Model.Room;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        String query = "SELECT AllClassrooms.* FROM AllClassrooms JOIN bookinghasroom ON id=bookinghasroom.vehicleId WHERE bookinghasroom.bookingId=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, booking.getId());
            ResultSet set = statement.executeQuery();
            return buildModels(set);
        } catch (Exception e) {
            throw new SQLException("Could not get room for booking.", e);
        }
    }

    @Override
    public void insert(Classroom model) throws SQLException {
        super.insert(model);
        String insert = "INSERT INTO classroom VALUES (?, ?,)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insert)) {
            insertStatement.setInt(1, model.getId());
            insertStatement.setInt(2, model.getNumOfSeats());
            insertStatement.execute();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }



    @Override
    public void update(Classroom model) throws SQLException {
            try {
                super.update(model);
                // do eventual update here, nothing to do for now though
            } catch (Exception e) {
                throw new SQLException("Could not update classroom table", e);
            }
        }

    @Override
    public void inactivate(Classroom model) throws SQLException {
        super.inactivate(model);
    }

    @Override
    public void delete(Classroom model) throws SQLException {

    }

    @Override
    public List<Classroom> readAll() throws SQLException {
        List<Classroom> classrooms = new ArrayList<>();
        String query = "SELECT * FROM AllClassrooms WHERE inBooking=1";
        try (Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(query);
           classrooms = buildModels(set);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return classrooms;
    }

    public List<Classroom> readAllIncludingInactive() throws SQLException {
        List<Classroom> classrooms = new ArrayList<>();
        String query = "SELECT * FROM AllClassrooms";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            classrooms.addAll(buildModels(statement.executeQuery()));
        } catch (Exception e) {
            throw new SQLException("Could not fetch cars", e);
        }
        return classrooms;
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

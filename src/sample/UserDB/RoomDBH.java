package sample.UserDB;

import sample.DataBaseConsole.ModelDBHandler;
import sample.Model.Booking;
import sample.Model.Classroom;
import sample.Model.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class RoomDBH <R extends Room> extends ModelDBHandler<R> {

    public static <R extends Room> RoomDBH getHandlerFor(R model) {
        if (model instanceof Classroom) {
            return new ClassroomDBH();
        } else {
            System.out.println("No!");
            return null;
        }
    }

    public static List<? extends Room> readAvailableRooms(Time startTime, Time endTime, Date startDate, Date endDate) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        try (ClassroomDBH dbHandler = new ClassroomDBH()) {
            rooms.addAll(dbHandler.readAvailable(startTime,endTime,startDate,endDate));
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return rooms;
    }

    public abstract List<? extends Room> readAvailable(Time startTime, Time endTime, Date startDate, Date endDate) throws SQLException;

    public static List<Room> readForBooking(Booking booking) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        try (ClassroomDBH classroomDBH = new ClassroomDBH()) {
            rooms.addAll(classroomDBH.readForBookingSpecific(booking));
        } catch (Exception e) {
            throw new SQLException("Trouble reading rooms for booking.", e);
        }
        return rooms;
    }

    public static Room readAbstractByPrimaryKey(String key) throws SQLException {
        try (ClassroomDBH classroomDBH = new ClassroomDBH()) {
            return classroomDBH.readByPrimaryKey(key);
        } catch (Exception e) {
            throw new SQLException("Could not read abstract room", e);
        }
    }

    public static List<Room> readAbstractAll() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        try (ClassroomDBH classroomDBH = new ClassroomDBH()){
            rooms.addAll(classroomDBH.readAll());
        } catch (Exception e) {
            throw new SQLException("Cannot read room: " + e.getMessage(), e);
        }
        return rooms;
    }

    public abstract List<R> readForBookingSpecific(Booking booking) throws SQLException;


    @Override
    public void insert(R model) throws SQLException {

        String insert = "INSERT INTO room (whiteboard, projector, numberOfSeats, isBooked, hasSpeaker)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String getId = "SELECT LAST_INSERT_ID() as id";
        try (PreparedStatement insertStatement = connection.prepareStatement(insert);
             PreparedStatement getIdStatement = connection.prepareStatement(getId)) {
            insertStatement.setString(1, model.getWhiteboard());
            insertStatement.setString(2, model.getProjector());
            insertStatement.setInt(3, model.getNumOfSeats());
            insertStatement.setString(4, model.getIsBooked());
            insertStatement.setString(5, model.getHasSpeaker());
            insertStatement.execute();
            ResultSet set = getIdStatement.executeQuery();
            while (set.next()) {
                model.setId(set.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(R model) throws SQLException {
        String query = "UPDATE room SET isBooked=?, hasProjector =? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, model.getIsBooked());
            statement.setString(2, model.getProjector());
            statement.setInt(3, model.getId());
            if (statement.executeUpdate() != 1) {
                throw new SQLException("No room with id: " + model.getId());
            }
        } catch (Exception e) {
            throw new SQLException("Could not update room: " + model.getId(), e);
        }
    }

    public void inactivate(R model) throws SQLException {
        String query = "UPDATE room SET inInventory=0 WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, model.getId());
            if (statement.executeUpdate() != 1) {
                throw new SQLException("No room with id: " + model.getId() + " found.");
            }
        } catch (Exception e) {
            throw new SQLException("Could not disable room.");


        }

    }

    @Override
    public void delete(R model) throws SQLException {

    }

    public static Room buildSingle(ResultSet set) {
        return ClassroomDBH.buildSingle(set);
    }
}


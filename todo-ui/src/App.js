import { useEffect, useState } from "react";
import { getTasks, createTask, updateTask, deleteTask } from "./services/api";
import TaskForm from "./components/TaskForm";
import TaskList from "./components/TaskList";

function App() {
  const [tasks, setTasks] = useState([]);

  const loadTasks = async () => {
    const data = await getTasks();
    setTasks(data);
  };

  useEffect(() => {
    loadTasks();
  }, []);

  const handleSave = async (task) => {
    await createTask(task);
    loadTasks();
  };

  const handleUpdate = async (id, updatedTask) => {
    await updateTask(id, updatedTask);
    loadTasks();
  };

  const handleDelete = async (id) => {
    await deleteTask(id);
    loadTasks();
  };

  const pendingTasks = tasks.filter((t) => !t.completed);
  const completedTasks = tasks.filter((t) => t.completed);

  return (
    <div className="min-h-screen bg-gray-100 p-6">
      <h1 className="text-4xl font-bold text-center mb-8">Mi Kanban To-Do List</h1>
      <div className="flex justify-center mb-8">
        <TaskForm onSave={handleSave} />
      </div>

      <div className="flex gap-6 justify-center flex-wrap">
        <TaskList
          title="Pendientes"
          tasks={pendingTasks}
          onUpdate={handleUpdate}
          onDelete={handleDelete}
          statusColor="yellow"
        />
        <TaskList
          title="Completadas"
          tasks={completedTasks}
          onUpdate={handleUpdate}
          onDelete={handleDelete}
          statusColor="green"
        />
      </div>
    </div>
  );
}

export default App;

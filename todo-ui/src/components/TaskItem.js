export default function TaskItem({ task, onUpdate, onDelete }) {
  const toggleComplete = () => {
    onUpdate(task.id, { ...task, completed: !task.completed });
  };

  return (
    <div className={`bg-white p-4 mb-4 rounded-lg shadow hover:shadow-lg transition`}>
      <h3 className={`font-semibold text-lg ${task.completed ? 'text-green-600' : 'text-yellow-600'}`}>
        {task.title}
      </h3>
      <p className={`text-gray-700 ${task.completed ? 'line-through' : ''}`}>{task.description}</p>
      <div className="flex gap-2 mt-3">
        <button
          onClick={toggleComplete}
          className={`px-3 py-1 rounded text-white ${
            task.completed ? "bg-yellow-500 hover:bg-yellow-600" : "bg-green-500 hover:bg-green-600"
          } transition`}
        >
          {task.completed ? "Pendiente" : "Completada"}
        </button>
        <button
          onClick={() => onDelete(task.id)}
          className="px-3 py-1 rounded bg-red-500 hover:bg-red-600 text-white transition"
        >
          Eliminar
        </button>
      </div>
    </div>
  );
}

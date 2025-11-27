import TaskItem from "./TaskItem";

export default function TaskList({ title, tasks, onUpdate, onDelete, statusColor }) {
  return (
    <div className="w-80 bg-gray-50 rounded-lg shadow p-4">
      <h2 className={`text-xl font-bold mb-4 text-${statusColor}-600`}>{title}</h2>
      {tasks.length === 0 ? (
        <p className="text-gray-400">Sin tareas</p>
      ) : (
        tasks.map((task) => (
          <TaskItem
            key={task.id}
            task={task}
            onUpdate={onUpdate}
            onDelete={onDelete}
            statusColor={statusColor}
          />
        ))
      )}
    </div>
  );
}
